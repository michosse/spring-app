export class CarAdd {
  brand: string='';
  firstDay: string | undefined;
  mechanicNip: string='';
  constructor(brand: string, firstDay: string, mechanicNip: string) {
    this.brand=brand;
    this.firstDay=firstDay;
    this.mechanicNip=mechanicNip;
  }
}
