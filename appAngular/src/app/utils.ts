export class Utils {
  
  public static getObjectInArray(key: string, val, array){
    if ( array != null ){
      for (var i = 0; array.length > i; i += 1){
        if (array[i][key] == val ){
          return array[i];
        }
      }
    }
  }
  
}