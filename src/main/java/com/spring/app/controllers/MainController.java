package com.spring.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @GetMapping("findAverageSalaryByCountry")
    public ResponseEntity<Double> findAverageSalaryByCountry(@RequestParam String country, Map<String, Object> model) {

        EntityManager session = entityManagerFactory.createEntityManager();
        try {
            double age = (Double)session.createNativeQuery("SELECT AVG(vacancy.salary) FROM country INNER JOIN company " +
                    "ON country.country_id = company.country_id INNER JOIN vacancy ON company.company_id = vacancy.company_id " +
                    "WHERE country.name = ?1 AND vacancy.opened = TRUE")
                    .setParameter(1, country)
                    .getSingleResult();

            return new ResponseEntity<>(age, HttpStatus.OK);
        }
        catch (NoResultException e){


            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        finally {
            if(session.isOpen()) session.close();
        }

    }

    @GetMapping("findAverageAgeByCountry")
    public ResponseEntity<Long> findAverageAgeByCountry(@RequestParam String country, Map<String, Object> model) {

//        EntityManager session = entityManagerFactory.createEntityManager();
//        try {
//            double age = (Double)session.createNativeQuery("SELECT AVG(Now() - employee.birthday) FROM country " +
//                    "INNER JOIN company ON country.country_id = company.country_id " +
//                    "INNER JOIN vacancy ON company.company_id = vacancy.company_id " +
//                    "INNER JOIN employee ON vacancy.employee_id = employee.employee_id " +
//                    "WHERE country.name = ?1 AND vacancy.opened = TRUE")
//                    .setParameter(1, country)
//                    .getSingleResult();
//
//            return new ResponseEntity<>(Math.round(age), HttpStatus.OK);
//        }
//        catch (NoResultException e){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        finally {
//            if(session.isOpen()) session.close();
//        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("findAverageExperienceByCountry")
    public ResponseEntity<Double> findAverageExperienceByCountry(@RequestParam String country, Map<String, Object> model) {

//        EntityManager session = entityManagerFactory.createEntityManager();
//        try {
//            Object age = session.createNativeQuery("SELECT AVG(Now()- employee.first_work_day) FROM employee " +
//                    "INNER JOIN vacancy ON employee.employee_id = vacancy.employee_id " +
//                    "INNER JOIN company ON vacancy.company_id = company.company_id " +
//                    "INNER JOIN country ON company.country_id = country.country_id " +
//                    "WHERE country.name = ?1 AND vacancy.opened = TRUE")
//                    .setParameter(1, country)
//                    .getSingleResult();
//
//            return new ResponseEntity<>(123d, HttpStatus.OK);
//        }
//        catch (NoResultException e){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        finally {
//            if(session.isOpen()) session.close();
//        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
    @GetMapping("findAverageNumberOfEmployeesByCountry")
    public ResponseEntity<BigInteger> findAverageNumberOfEmployeesByCountry(@RequestParam String country, Map<String, Object> model) {

        EntityManager session = entityManagerFactory.createEntityManager();
        try {
            BigDecimal age = (BigDecimal)session.createNativeQuery("SELECT AVG (count_table.number_of_emp) " +
                    "FROM( " +
                         "SELECT COUNT(vacancy.vacancy_id) as number_of_emp, company.name " +
                         "FROM company JOIN country ON company.country_id = country.country_id " +
                         "             JOIN vacancy ON vacancy.company_id = company.company_id " +
                         "WHERE country.name = ?1 AND vacancy.opened = TRUE\n" +
                         "GROUP BY company.name) AS count_table")
                    .setParameter(1, country)
                    .getSingleResult();

            return new ResponseEntity<>(age.toBigInteger(), HttpStatus.OK);
        }
        catch (NoResultException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        finally {
            if(session.isOpen()) session.close();

        }

    }
}
