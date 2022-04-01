
class SpecialistEmployee(name: String, surname: String, pay: Double, var bonus: Double)
    extends Employee(name, surname, pay) {

    def Bonus(newBonus: Double): Unit = {
      if (bonus <= 0) {throw new IllegalArgumentException("must be >0")}
      else {this.bonus = bonus + newBonus}
    }

    override def toString(): String = "Employee{" + "name='" + name + ", surname='" + surname + " pay=" + surname + ", bonus=" + bonus + '}'

  }

