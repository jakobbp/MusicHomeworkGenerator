package jbp.notes.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import jbp.notes.annotations.GeneratorMethod;
import jbp.notes.annotations.HomeworkGenerator;

public final class NotesUtil {
	public static final String DEFAULT_OUTPUT_FILE_NAME_TEMPLATE = "Sheet-%2$s-%1$02d.png";
	public static final String DEFAULT_OUTPUT_FILE_TYPE = "PNG";
	
	private static final String TYPE_KEY_DELIMITER = ":";
	private static final String TYPE_KEY_TEMPLATE = "%s%s%s";
	private static final String TYPE_SUFFIX_TEMPLATE = "%s%s";
	
	private static NotesUtil instance;
	
	private Map<String, HomeworkTypeMetadata> metadataByHomeworkType;
	
	private NotesUtil() {
		//EMPTY
	}
	
	public synchronized static NotesUtil getInstance() {
		if(instance == null) {
			instance = new NotesUtil();
		}
		return instance;
	}
	
	public static String generateDefaultHomeworkTypeSuffix() {
		try {
			StackTraceElement callerElement = Thread.currentThread().getStackTrace()[2];
			
			String className = callerElement.getClassName();
			Class<?> generatorClass = Class.forName(className);
			HomeworkGenerator classAnnotation = generatorClass.getAnnotation(HomeworkGenerator.class);
			if(classAnnotation == null) {
				throw new IllegalStateException("Calling class ["+className+"] is not @HomeworkGenerator");
			}
			String generatorTypeID = classAnnotation.value();
			
			String methodName = callerElement.getMethodName();
			Method generatorMethod = generatorClass.getDeclaredMethod(methodName, int.class);
			GeneratorMethod methodAnnotation = generatorMethod.getAnnotation(GeneratorMethod.class);
			if(methodAnnotation == null) {
				throw new IllegalStateException("Calling method ["+methodName+"] is not @GeneratorMethod");
			}
			String homeworkTypeID = methodAnnotation.typeId();
			return String.format(TYPE_SUFFIX_TEMPLATE, generatorTypeID, homeworkTypeID);
		} catch(ClassNotFoundException | NoSuchMethodException | SecurityException e) {
			throw new IllegalStateException("Could not generate default homework type suffix: "+e.getMessage(), e);
		}
	}
	
	public Map<String, String> getAvailableHomeworkTypes() {
		Map<String, String> availableHomeworkTypes = new TreeMap<>();
		for(HomeworkTypeMetadata metadata : getMetadataByHomeworkType().values()) {
			availableHomeworkTypes.put(metadata.getTypeID(), metadata.getDescription());
		}
		return availableHomeworkTypes;
	}
	
	public void invokeGeneratorMethodByHomeworkType(String homeworkType, int nPages) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		HomeworkTypeMetadata homeworkTypeMetadata = getMetadataByHomeworkType().get(homeworkType);
		Class<?> generatorClass = homeworkTypeMetadata.getGeneratorClass();
		Object generatorInstance = generatorClass.getConstructor().newInstance();
		Method generatorMethod = homeworkTypeMetadata.getGeneratorMethod();
		generatorMethod.invoke(generatorInstance, nPages);
	}
	
	private synchronized Map<String, HomeworkTypeMetadata> getMetadataByHomeworkType() {
		if(metadataByHomeworkType == null) {
			loadHomeworkMetadata();
		} return metadataByHomeworkType;
	}
	
	private synchronized void loadHomeworkMetadata() {
		try {
			List<Class<?>> loadedClasses = getLoadedClasses();
			Map<String, HomeworkTypeMetadata> metadataMapping = new HashMap<>();
			for(Class<?> loadedClass : loadedClasses) {
				HomeworkGenerator generatorAnnotation = loadedClass.getAnnotation(HomeworkGenerator.class);
				if(generatorAnnotation == null) {
					continue;
				}
				String generatorTypeID = generatorAnnotation.value();
				
				for(Method method : loadedClass.getDeclaredMethods()) {
					GeneratorMethod methodAnnotation = method.getAnnotation(GeneratorMethod.class);
					if(methodAnnotation == null) {
						continue;
					}
					String methodTypeID = methodAnnotation.typeId();
					String methodDescription = methodAnnotation.description();
					String typeKey = String.format(TYPE_KEY_TEMPLATE, generatorTypeID, TYPE_KEY_DELIMITER, methodTypeID);
					metadataMapping.put(typeKey, new HomeworkTypeMetadata(typeKey, loadedClass, method, methodDescription));
				}
			}
			
			metadataByHomeworkType = metadataMapping;
		} catch (ClassNotFoundException | SecurityException | IOException e) {
			System.err.println("Error while searching for all homework generators: "+e.getMessage());
		}
	}
	
	private static List<Class<?>> getLoadedClasses() throws IOException, ClassNotFoundException {
		ClassLoader currentLoader = Thread.currentThread().getContextClassLoader();
		String packageName = NotesUtil.class.getPackage().getName();
		String rootPackage = packageName.substring(0, packageName.indexOf('.'));
		Enumeration<URL> resources = currentLoader.getResources(rootPackage);
		
		List<File> dirs = new ArrayList<>();
		while(resources.hasMoreElements()) {
			URL res = resources.nextElement();
			dirs.add(new File(res.getFile()));
		}
		
		List<Class<?>> classes = new ArrayList<>();
		for(File dir : dirs) {
			classes.addAll(findClasses(dir, rootPackage));
		}
		return classes;
	}
	
	private static List<Class<?>> findClasses(File dir, String packageName) throws ClassNotFoundException {
		List<Class<?>> classes = new ArrayList<>();
		if(!dir.exists()) {
			return classes;
		}
		
		File[] files = dir.listFiles();
		for(File file : files) {
			if(file.isDirectory()) {
				classes.addAll(findClasses(file, packageName+"."+file.getName()));
			} else if(file.getName().endsWith(".class")) {
				String className = packageName+"."+file.getName().substring(0, file.getName().length()-6);
				classes.add(Class.forName(className));
			}
		}
		return classes;
	}
	
	private class HomeworkTypeMetadata {
		private String typeID;
		private Class<?> generatorClass;
		private Method generatorMethod;
		private String description;
		
		public HomeworkTypeMetadata(String typeID, Class<?> generatorClass, Method generatorMethod, String description) {
			this.typeID = typeID;
			this.generatorClass = generatorClass;
			this.generatorMethod = generatorMethod;
			this.description = description;
		}
		
		public String getTypeID() {
			return typeID;
		}
		
		public Class<?> getGeneratorClass() {
			return generatorClass;
		}
		
		public Method getGeneratorMethod() {
			return generatorMethod;
		}
		
		public String getDescription() {
			return description;
		}
	}
}