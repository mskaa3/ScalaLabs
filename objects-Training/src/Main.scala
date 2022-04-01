object Main {

  def main(args: Array[String]): Unit = {
    val specialist: SpecialistEmployee =
      new SpecialistEmployee("Sandra", "Bullock", 3000, 100)
    val employee: Employee = new Employee("Adam", "Blue", 1500)

    employee.payIncrease(10)
    println(employee.toString)
    specialist.Bonus(200)
    println(specialist.toString)
    val company: Company = new Company()
    company.addEmployee(specialist)

    company.addEmployee(employee)
    println(company.toString)
    company.increase(10)
    println(company.toString)
    company.addBonus(100);
    println(company.toString)
  }

}
