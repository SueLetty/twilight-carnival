package com.twilightCarnival.model;

import java.util.Arrays;

/**
 * InputValidator checks user's input and assigns to a field proper input choices if valid.
 */
public class InputValidator {

  private String[] input = new String[2];
  private String inputVerb;
  private String inputNoun;
  private final String[] pickUpVerbs = {"pickup", "acquire", "search", "grab"};
  private final String[] mapVerbs = {"use", "open", "view"};
  private final String[] navigationVerbs = {"go", "travel", "walk", "move"};
  private final String[] nouns = {"map", "key", "master key", "keys", "bronze key", "gold key",
      "silver key"};
  Directions[] directions = Directions.values();

  /**
   * isValid Method takes input string and populates private field that hold a proper input.
   * @param input String the user inputs for an action of using an item or moving.
   * @return boolean that states the input is valid and the input is put in a String[] input field.
   */
  public boolean isValid(String input) {
    boolean result = false;
    boolean verbCondition = false;
    boolean nounCondition = false;
    String tempVerb;
    String tempNoun;
    String[] unfilteredString = input.split(" ");
    for (String str : unfilteredString) {
      if (!verbCondition){
        verbCondition = isAValidVerb(str);
      } else if (!nounCondition) {
        nounCondition = isAValidNoun(str);
      }
    }
    if (verbCondition && nounCondition) {
      this.input[0] = inputVerb;
      this.input[1] = inputNoun;
      result = true;
    } else {
      result = false;
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
    } else if (Arrays.asList(directions).toString().contains(noun.toUpperCase())) {
      inputNoun = noun.toUpperCase();
      isNoun = true;
    }
    // TODO: 12/9/2022 check for enum values
    return isNoun;
  }

  /**
   * validCombination that will check for valid input combo.
   * @return boolean if the combination is valid.
   */
  private boolean validCombination(){
    boolean result = false;
    switch (input[0]){
      case "pickup":
        if(isAValidNoun(input[1])){
          result = true;
        }
        break;
      case "open":
        if(input[1].equals("map")){
          result = true;
        }
        break;
      case "go":
        if(Arrays.asList(directions).toString().contains(input[1].toUpperCase())){
          // TODO: 12/9/2022 complete logic for checking for valid direction
        }
        break;
      default:
        result = false;
    }
    return result;
  }
}
