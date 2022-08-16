package xyz.michaelzhao.typer.game;

public enum GuessStatus {
    /**
     * The word is in the current list of active words
     */
    CORRECT,

    /**
     * The word is not in the dictionary of words
     */
    INVALID_WORD,

    /**
     * The word is not in the current list of active words
     */
    WRONG
}
