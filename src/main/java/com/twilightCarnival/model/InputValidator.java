package com.twilightCarnival.model;

import java.util.Arrays;

/**
 * InputValidator checks user's input and assigns to a field proper input choices if valid.
 */
public class InputValidator {

  private final String[] input = new String[2];
  private String inputVerb;
  private String inputNoun;
  private final String[] pickUpVerbs = {"pickup", "acquire", "search", "grab", "pick-up"};
  private final String[] mapVerbs = {"use", "open", "view", "render"};
  private final String[] navigationVerbs = {"go", "travel", "walk", "move", "run", "sprint"};
  private final String[] nouns = {"map", "key", "master key", "keys", "bronze key", "gold key",
      "silver key"};
  private final Directions[] directions = Directions.values();

  /**
   * isValid Method takes input string and populates private field that hold a proper input.
   *  It does not handle conjunctions.
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
      if (!verbCondition) {
        verbCondition = isAValidVerb(str);
      } else if (!nounCondition) {
        nounCondition = isAValidNoun(str);
      }
    }
    if (verbCondition && nounCondition) {
      this.input[0] = inputVerb;
      this.input[1] = inputNoun;

      if (validCombination()) {
        result = true;
      } else {
        System.out.printf("You cannot \"%s %s\", it is not a valid input.\n", this.input[0], this.input[1]);
        System.out.println("Try something like:\n \t> open map\n \t> go north\n");
      }
    } else {
      System.out.println("Could not collect a valid input.");
      System.out.println("Try something like:\n \t> pickup map\n \t> go south\n");
      result = false;
    }

    return result;
  }

  /**
   * getInput() gets the field String[] input, that holds 2 strings for proper verb[0] and noun[1].
   *
   * @return String[] input. [0] verb, [1] noun.
   */
  public String[] getInput() {
    return input;
  }

  /**
   * isAValidVerb(String verb) called to check if input is a proper whitelisted verb to be assigned
   * to String[] input;
   *
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
   *
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
    return isNoun;
  }

  /**
   * validCombination that will check for valid input combination.
   *  Current valid combinations is tied to keywords given to input[0] during isAValid[Noun/Verb]()
   *  methods.
   * @return boolean if the combination is valid/invalid.
   */
  private boolean validCombination() {
    boolean result = false;
    switch (input[0]) {
      case "pickup":
        if (isAValidNoun(input[1])) {
          result = true;
        }
        break;
      case "open":
        if (input[1].equals("map")) {
          result = true;
        }
        break;
      case "go":
        if (Arrays.asList(directions).toString().contains(input[1].toUpperCase())) {
          result = true;
        }
        break;
      default:
        result = false;
    }
    return result;
  }
}
