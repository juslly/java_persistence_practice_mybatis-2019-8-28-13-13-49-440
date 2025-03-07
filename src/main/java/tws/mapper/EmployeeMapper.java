package tws.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.http.ResponseEntity;

import tws.entity.Employee;


@Mapper
public interface EmployeeMapper {

	@Insert("insert into employee values(#{employee.id},#{employee.name},#{employee.age})")
	public void insertEmployee(@Param("employee") Employee employee);

	@Select("select * from employee")
	public List<Employee> selectEmployees();

	@Update("update employee set name ='jing',age = 13 where id = #{id}")
	public void updateEmployee(@Param("id") int id);

	@Delete("delete from employee where id = #{id}")
	public void deleteEmployee(@Param("id") int id);

}