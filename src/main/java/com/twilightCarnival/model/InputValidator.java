package com.twilightCarnival.model;

import java.util.Arrays;

/**
 * InputValidator checks user's input and assigns to a field proper input choices if valid.
 */
public class InputValidator {

  private String[] input = new String[2];
  private String inputVerb;
  private String inputNoun;
  private final String[] pickUpVerbs = {"pickup", "acquire", "search"};
  private final String[] mapVerbs = {"use", "open"};
  private final String[] navigationVerbs = {"go", "travel", "walk", "move"};
  private final String[] nouns = {"map", "key", "master key", "keys", "bronze key", "gold key",
      "silver key"};

  /**
   * isValid Method takes input string and populates private field that hold a proper input.
   * @param input String the user inputs for an action of using an item or moving.
   * @return boolean that states the input is valid and the input is put in a String[] input field.
   */
  public boolean isValid(String input) {
    boolean result = false;
    String[] unfilteredString = input.split(" ");
    for (String str : unfilteredString) {
      boolean verbCondition = isAValidVerb(str);
      boolean nounCondition = isAValidNoun(str);
      if (verbCondition && nounCondition) {
        this.input[0] = inputVerb;
        this.input[1] = inputNoun;
        result = true;
      } else {
        result = false;
      }
    }

    return result;
  }

  /**
   * getInput() gets the field String[] input, that holds 2 strings for proper verb[0] and noun[1].
   * @return String[] input. [0] verb, [1] noun.
   */
  public String[] getInput() {
    return input;
  }

  /**
   * isAValidVerb(String verb) called to check if input is a proper whitelisted verb to be assigned
   * to String[] input;
   * @param verb String value to be checked if it is a whitelisted verb.
   * @return boolean value if the string passed is whitelisted verb.
   */
  private boolean isAValidVerb(String verb) {
    boolean isVerb = false;
    if (Arrays.asList(pickUpVerbs).contains(verb.toLowerCase())) {
      inputVerb = "pickup";
      isVerb = true;
    } else if (Arrays.asList(mapVerbs).contains(verb.toLowerCase())) {
      inputVerb = "open";
      isVerb = true;
    } else if (Arrays.asList(navigationVerbs).contains(verb.toLowerCase())) {
      inputVerb = "go";
      isVerb = true;
    }

    return isVerb;
  }

  /**
   * isAValidNoun(String noun) called to check if input is a proper whitelisted noun to be assigned
   * to String[] input.
   * @param noun String value to be checked if it is a whitelisted noun.
   * @return boolean value if the string passed is whitelisted noun.
   */
  private boolean isAValidNoun(String noun) {
    boolean isNoun = false;
    if (Arrays.asList(nouns).contains(noun.toLowerCase())) {
      inputNoun = noun.toLowerCase();
      isNoun = true;
    }

    return isNoun;
  }
}
