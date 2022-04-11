package com.juliooliveirajr.diabetescontrol.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.juliooliveirajr.diabetescontrol.entity.BloodGlucose;

@Repository
public interface IBloodGlucoseRepository extends JpaRepository<BloodGlucose, Integer> {
	@Query(nativeQuery = true, value="SELECT * FROM BLOOD_GLUCOSE G where G.GLUCOSE_DATE = :glucoseDate AND G.GLUCOSE_HOUR = :glucoseHour")
	public List<BloodGlucose> searchForDateHour(LocalDateTime glucoseDate, String glucoseHour);
	
	@Query(nativeQuery = true, value="SELECT * FROM BLOOD_GLUCOSE G where G.GLUCOSE_DATE BETWEEN :from AND :to")
	public List<BloodGlucose> searchForPeriod(LocalDateTime from, LocalDateTime to);
	
	@Query(nativeQuery = true, value="SELECT * FROM BLOOD_GLUCOSE G where G.GLUCOSE_DATE BETWEEN :startDate AND :today")
	public List<BloodGlucose> searchForWeek(LocalDateTime today, LocalDateTime startDate);
}
