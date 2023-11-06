package tobeto_spring_tutorial.data.requests.Product;

public record UpdateProductReq(int id, String newName, int categoryId, int newCategoryId ) {

}
