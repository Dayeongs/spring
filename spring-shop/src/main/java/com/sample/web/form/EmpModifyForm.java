package com.sample.web.form;

import com.sample.vo.Employee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EmpModifyForm extends EmpCreateForm {

   private int no;
   
   /*
    * @Override
    * 	어노테이션의 의미는 상위 타입(부모 타입)의 메서드를 재정의했음을 의미한다.
    * 	이 어노테이션을 통해 쉽게 잘못된 부분을 찾을 수 있다.
    */
   @Override
   public Employee toEmployee() {
      Employee emp = super.toEmployee();
      emp.setNo(no);
      
      return emp;
   }
}
