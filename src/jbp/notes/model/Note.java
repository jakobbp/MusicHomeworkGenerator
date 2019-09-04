package jbp.notes.model;

public class Note {
	public static final NoteDuration DEFAULT_DURATION = NoteDuration.QUARTER;
	
	private String name;
	private int cOffset;
	private NoteDuration duration;
	private boolean dot;
	private boolean sharp;
	private boolean flat;
	private boolean natural;
	
	public Note(String name, int cOffset) {
		this(name, cOffset, DEFAULT_DURATION);
	}
	
	public Note(String name, int cOffset, NoteDuration duration) {
		this(name, cOffset, duration, false, false, false, false);
	}
	
	public Note(String name, int cOffset, NoteDuration duration, boolean dot, boolean sharp, boolean flat, boolean natural) {
		this.name = name;
		this.cOffset = cOffset;
		this.duration = duration;
		this.dot = dot;
		this.sharp = sharp;
		this.flat = flat;
		this.natural = natural;
	}
	
	public String getName() {
		return name;
	}
	
	public int getCOffset() {
		return cOffset;
	}
	
	public NoteDuration getDuration() {
		return duration;
	}
	
	public void setDuration(NoteDuration duration) {
		this.duration = duration;
	}
	
	public boolean isDot() {
		return dot;
	}
	
	public void setDot(boolean dot) {
		this.dot = dot;
	}
	
	public boolean isSharp() {
		return sharp;
	}
	
	public void setSharp(boolean sharp) {
		this.sharp = sharp;
	}
	
	public boolean isFlat() {
		return flat;
	}
	
	public void setFlat(boolean flat) {
		this.flat = flat;
	}
	
	public boolean isNatural() {
		return natural;
	}
	
	public void setNatural(boolean natural) {
		this.natural = natural;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cOffset;
		result = prime * result + (dot ? 1231 : 1237);
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + (flat ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (natural ? 1231 : 1237);
		result = prime * result + (sharp ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Note other = (Note)obj;
		if(cOffset != other.cOffset)
			return false;
		if(dot != other.dot)
			return false;
		if(duration != other.duration)
			return false;
		if(flat != other.flat)
			return false;
		if(name == null) {
			if(other.name != null)
				return false;
		} else if(!name.equals(other.name))
			return false;
		if(natural != other.natural)
			return false;
		if(sharp != other.sharp)
			return false;
		return true;
	}
}