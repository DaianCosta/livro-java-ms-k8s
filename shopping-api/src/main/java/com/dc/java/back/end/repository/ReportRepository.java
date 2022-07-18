package com.dc.java.back.end.repository;

import com.dc.java.back.end.dto.ShopReportDTO;
import com.dc.java.back.end.model.Shop;

import java.util.Date;
import java.util.List;

public interface ReportRepository {

    public List<Shop> getShopByFilters(Date dataInicio, Date dataFim, Float valorMinimo);

    public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim);

}
