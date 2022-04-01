
class Company {


  var employeeList:List[Employee]=List()

    def addEmployee(emp: Employee): Unit = {
      employeeList=employeeList++List(emp)
    }

    def increase(percent: Int): Unit = {
      if (percent<= 0) {throw new IllegalArgumentException("must be >0")}
      else {
        for (emp <- employeeList) {
          emp.payIncrease(percent)
        }
      }
    }

    def addBonus(bonus: Int): Unit = {
      if (bonus <= 0) {throw new IllegalArgumentException("must be >0")}
      for (emp <- employeeList
           if emp.isInstanceOf[SpecialistEmployee]) {emp.asInstanceOf[SpecialistEmployee].Bonus(bonus)}
    }
  override def toString(): String = "Company{" + "employees=" + employeeList.toString() + "}"

  }

