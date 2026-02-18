package com.hthjsj.md.demo.service;

import com.github.md.analysis.SpringAnalysisManager;
import com.jfinal.plugin.activerecord.Record;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author pengxg
 * @Date 2024-10-18 10:16
 */
@Service
public class StockLogService {

    public Record getStockLog(Long id) {
        return SpringAnalysisManager.me().dbMain().findById("t_stock_log", id);
    }
}
