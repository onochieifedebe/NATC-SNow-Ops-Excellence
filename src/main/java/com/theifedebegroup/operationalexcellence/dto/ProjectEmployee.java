package com.theifedebegroup.operationalexcellence.dto;

import java.sql.Date;

public interface ProjectEmployee {

    String getClLevel();

    String getFirstName();

    String getLastName();

    Date getStartDate();

    Date getEndDate();

    String getClientName();

    String getStatus();
}
