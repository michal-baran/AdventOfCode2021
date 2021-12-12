package com.advent.of.code.day4;

import java.util.List;

public class Board {
    Field[][] fields;
    boolean win;

    public Board(List<List<Field>> listFields) {
        fields = new Field[listFields.size()][listFields.get(0).size()];
        for (int i = 0; i < listFields.size(); i++) {
            for (int j = 0; j < listFields.get(0).size(); j++) {
                fields[i][j] = listFields.get(i).get(j);
            }
        }
    }

    public void markNumber(int number) {
        for (Field[] field : fields) {
            for (int i = 0; i < field.length; i++) {
                if (field[i].getNumber() == number) {
                    field[i].setMark();
                }
            }
        }
    }

    public boolean doesWin() {
        for (int i = 0; i < fields.length; i++) {
            if (win) return false;
            int columnMarkedCount = 0;
            int rowMarkedCount = 0;
            for (int j = 0; j < fields[i].length; j++) {
                if (fields[i][j].isMarked()) {
                    rowMarkedCount++;
                }
                if (fields[j][i].isMarked()) {
                    columnMarkedCount++;
                }
                if ((rowMarkedCount == fields[i].length) || (columnMarkedCount == fields.length)) {
                    win = true;
                    return true;
                }
            }
        }
        return false;
    }

    public int calculateResult(int number) {
        int result = 0;
        for (Field[] value : fields) {
            for (int i = 0; i < value.length; i++) {
                Field field = value[i];
                if (!field.isMarked()) {
                    result += field.getNumber();
                }
            }
        }
        return result * number;
    }
}