package ch.wh.service.impl;

import ch.wh.dao.EmployeeMapper;
import ch.wh.pojo.Employee;
import ch.wh.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceimpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public List<Employee> queryAll() {
        logger.info("queryAll");
        return employeeMapper.getAll();
    }
}
