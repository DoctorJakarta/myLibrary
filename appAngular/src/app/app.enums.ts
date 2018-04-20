

// This is globally accesiible with bookSection.CHILDRENS after this.bookStatus = EnumBookStatu
export enum EnumBookSection {
    // The values or enum NAME is passed to the JSON request, and the java enum NAME is returnned as a String
  BIOGRAPHY = 'BIOGRAPHY',
  BUSINESS = 'BUSINESS',
  CHILDREN = 'CHILDREN',
  COOKBOOK = 'COOKBOOK',
  HISTORY = 'HISTORY',
  LITERATURE = 'LITERATURE',
  MYSTERY = 'MYSTERY',
  SCIENCE = 'SCIENCE' 
}

// This is accessible with "fruitName.get(fruit.APPLE)" after this.fruitName = Fruit.getfruitNames()
const BookSectionNames = new Map<string, string>([
  [EnumBookSection.BIOGRAPHY , 'Biographies & Memoirs'],
  [EnumBookSection.BUSINESS , 'Business & Investing'],
  [EnumBookSection.CHILDREN , 'Childrens Books'],
  [EnumBookSection.COOKBOOK , 'Cookbooks, Food & Wine'],
  [EnumBookSection.HISTORY , 'History'],
  [EnumBookSection.LITERATURE , 'Literature & Fiction'],
  [EnumBookSection.MYSTERY , 'Mystery & Suspense'],
  [EnumBookSection.SCIENCE , 'Science']
])

export class AppEnums {
  
  public static getBookSectionNames(){ return BookSectionNames;}
  
}
  
