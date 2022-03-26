package com.tms.model;

import com.tms.model.CashBox;

public interface ChooseCashBoxStrategy {
    CashBox chooseCashBox(String customerName, CashBox[] cashBoxes);
}
