package com.pluralsight;

import com.pluralsight.models.SalesContract;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SalesDao {

    private BasicDataSource dataSource;

    public SalesDao(DataManager dataManager) {
        this.dataSource = dataManager.getDataSource();
    }

    private SalesContract createSalesContract (ResultSet results ) throws SQLException {

        SalesContract salesContract = new SalesContract();

        salesContract.setContract_id(results.getInt("contract_id"));
        salesContract.setVin(results.getString("vin"));
        salesContract.setSales_tax(results.getDouble("sales_tax"));
        salesContract.setRecording_fee(results.getDouble("recording_fee"));
        salesContract.setProcessing_fee(results.getDouble("procesing_fee"));
        salesContract.setFinance_status(results.getBoolean("finance_status"));
        salesContract.setSale_date(results.getDate("sale_date"));

        return salesContract;



    }
}
