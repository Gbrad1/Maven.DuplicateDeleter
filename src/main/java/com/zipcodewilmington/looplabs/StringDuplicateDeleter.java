package com.zipcodewilmington.looplabs;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {

    public StringDuplicateDeleter(String[] stringArray) {
        super(stringArray);
    }

    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        String[] buffer = new String[array.length];
        int index = 0;
        String lastSeen = array[0];
        int currentCountNum = 0;


        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(lastSeen)) {
                currentCountNum++;
            } else {
                if (currentCountNum < maxNumberOfDuplications) {
                    for (int j = 0; j < currentCountNum; j++) {
                        buffer[index] = lastSeen;
                        index++;
                    }
                }
                lastSeen = array[i];
                currentCountNum = 1;
            }
        }

        String[] toReturn = new String[index];

        for (int i = 0; i < index; i++) {
            toReturn[i] = buffer[i];
        }

        return toReturn;
    }

    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        String[] buffer = new String[array.length];
        int index = 0;
        String lastSeen = array[0];
        int currentCountNum = 0;


        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(lastSeen)) {
                currentCountNum++;
            } else {
                if (currentCountNum != exactNumberOfDuplications) {
                    for (int j = 0; j < currentCountNum; j++) {
                        buffer[index] = lastSeen;
                        index++;
                    }
                }
                lastSeen = array[i];
                currentCountNum = 1;
            }
        }

        if (currentCountNum != exactNumberOfDuplications) {
            for (int j = 0; j < currentCountNum; j++) {
                buffer[index] = lastSeen;
                index++;
            }
        }

        String[] toReturn = new String[index];

        for (int i = 0; i < index; i++) {
            toReturn[i] = buffer[i];
        }

        return toReturn;
    }
}
