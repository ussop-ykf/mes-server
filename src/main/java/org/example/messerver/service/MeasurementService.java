package org.example.messerver.service;

import org.example.messerver.entity.Measurement;
import org.example.messerver.entity.Measurement;

import java.util.List;

/**
 * @author 27542
 */
public interface MeasurementService {
    List<Measurement> queryMeasurementList(Measurement measurement);
    Boolean addMeasurement(Measurement measurement);
    Boolean updateMeasurement(Measurement measurement);
    Boolean deleteMeasurement(Integer id);
}
