package com.zipcodewilmington.looplabs;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {

    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);
    }

    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
        Integer[] buffer = new Integer[array.length];
        int index = 0;
        int lastSeen = array[0];
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

        Integer[] toReturn = new Integer[index];

        for (int i = 0; i < index; i++) {
            toReturn[i] = buffer[i];
        }

        return toReturn;
    }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        Integer[] buffer = new Integer[array.length];
        int index = 0;
        int lastSeen = array[0];
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

        Integer[] toReturn = new Integer[index];

        for (int i = 0; i < index; i++) {
            toReturn[i] = buffer[i];
        }

        return toReturn;
    }
}
