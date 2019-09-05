# Music Homework Generator
Generator of random musical note sheets, used for generating homework when learning or teaching musical notes.

## About
Music homework generator is a *CLI* application for generating sheets of random notes, which can be used as homework practice sheets for practicing note recognition and transcription.
Generated sheets are stored as `.png` images and enumerated by homework type and page number.

## Usage
Running the application requires *Java Runtime Environment 7* or newer.
Assuming, that compiled classes are in the `bin` directory, it can be run like this:
```bash
java -cp ".;./bin" jbp.notes.NotesGenerator --type=<HW_TYPE> --pages=<N_PAGES>
```

where `<HW_TYPE>` is the type of homework and `<N_PAGES>` is the number of pages to be generated.

To see the list of all recognized homework types, use the `--help` argument:
```bash
java -cp ".;./bin" jbp.notes.NotesGenerator --help
```
