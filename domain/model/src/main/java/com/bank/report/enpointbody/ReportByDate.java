package com.bank.report.enpointbody;

import com.bank.commons.properties.Id;
import com.bank.commons.properties.State;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportByDate {
    private Id idClient;
    private State accountStatus;

    public ReportByDate(Id idClient, State accountStatus) {
        this.idClient = idClient;
        this.accountStatus = accountStatus;
    }
}
