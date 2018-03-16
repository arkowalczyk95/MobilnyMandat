package com.kowalczyk.arek.mobilnymandat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arek on 2017-09-14.
 */

public class FineDatabase {
    private List<Fine> fineList;

    public FineDatabase()   {
        fineList = new ArrayList<>();
    }

    public void addFine(Fine fine)  {
        fineList.add(fine);
    }

    public List<Fine> getFineList() {
        return fineList;
    }
}
