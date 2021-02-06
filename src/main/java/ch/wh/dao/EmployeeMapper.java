package ch.wh.dao;

import ch.wh.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface EmployeeMapper {
    public List<Employee> getAll();
}
