
class Employee(var name: String, var surname: String, var pay: Double) {

  def payIncrease(percent: Int): Unit = {
    if (percent <= 0) {throw new IllegalArgumentException("must be >0")}
    else {this.pay = pay + (pay * percent / 100)}
  }

  override def toString(): String = "Employee{" + "name='" + name  + ", surname='" + surname + ", pay=" + pay + '}'

}
