package com.example.employee.repository;

import com.example.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //以下所有的*都代表变量

    //1.查询名字是*的第一个employee
    Employee findFirstByName(String name);

    //2.找出Employee表中第一个姓名包含`*`字符并且薪资大于*的雇员个人信息

    //3.找出一个薪资最高且公司ID是*的雇员以及该雇员的姓名
    @Query(value = "from Employee where salary = (select max(salary) from Employee where id = :companyId)")
    Employee findTheHighestPaidEmployee(@Param("companyId") int companyId);

    //4.实现对Employee的分页查询，每页两个数据

    //5.查找**的所在的公司的公司名称
    @Query(value = "select e.name from Company c where c.id = e.companyId")
    String getCompanyName(Employee employee);

    //6.将*的名字改成*,输出这次修改影响的行数

    //7.删除姓名是*的employee
    void deleteByName(String name);
}
