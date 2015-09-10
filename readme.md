
##Problem Description :

Build an Application that applies the following rules to calculate the Total Amount of a set of goods.

 Product Characterization Rules :
 * Goods under the category books, food, medical products are exempted goods.
 * Goods are either imported or non-imported

 Tax-Calculation:
 * Basic Sales Tax is 0% on exempted goods(No Basic Sales Tax on empted goods)
 * Basic Sales Tax is 10% on non-exempted goods
 	-Rounding:
 		*Round to nearest 0.05

 Display Result:
 * List Format :
 ItemName-ItemPrice(After Taxation)
 Total Sales Tax
 Total Amount

##Dependencies :
    - JDK (1.6 or higher)
    - Apache Ant
    - JUnit (included under lib)
        - Hamcrest(included under lib)

##Steps to Build :
    1) Set present working directory to Project directory.
    2) Run the following command
        >ant






