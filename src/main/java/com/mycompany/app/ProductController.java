package com.mycompany.app;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mycompany.app.entities.MyProduct;

@Controller
public class ProductController {
    private boolean isInit = false;
    @Autowired ProductRepository productRepository;


    @GetMapping("/")
    public String displayProduct(Model model){
        
        if(!isInit)
            init();

        List<MyProduct> myProductsArr = productRepository.findAll();

        model.addAttribute("products",  myProductsArr);
        return "index.html";
    }

    @GetMapping("/productview/{id}")
    public String viewProduct(@PathVariable long id, Model model){
        System.out.println(id);

        Optional<MyProduct> product = productRepository.findById(id);
        model.addAttribute("product", product.get());

        return "productview.html";
    }
    
    private void init(){
        String prodDesc0 = "To understand the working functionality of Linear Regression, imagine how you would arrange random logs of wood in increasing order of their weight. There is a catch; however – you cannot weigh each log. You have to guess its weight just by looking at the height and girth of the log (visual analysis) and arranging them using a combination of these visible parameters. This is what linear regression in machine learning is like.";
        String prodDesc1 = "Logistic Regression is used to estimate discrete values (usually binary values like 0/1) from a set of independent variables. It helps predict the probability of an event by fitting data to a logit function. It is also called logit regression.";
        String prodDesc2 = "Decision Tree algorithm in machine learning is one of the most popular algorithm in use today; this is a supervised learning algorithm that is used for classifying problems. It works well in classifying both categorical and continuous dependent variables. This algorithm divides the population into two or more homogeneous sets based on the most significant attributes/ independent variables.";
        String prodDesc3 = "SVM algorithm is a method of a classification algorithm in which you plot raw data as points in an n-dimensional space (where n is the number of features you have). The value of each feature is then tied to a particular coordinate, making it easy to classify the data. Lines called classifiers can be used to split the data and plot them on a graph.";
        String prodDesc4 = "A Naive Bayes classifier assumes that the presence of a particular feature in a class is unrelated to the presence of any other feature.\nEven if these features are related to each other, a Naive Bayes classifier would consider all of these properties independently when calculating the probability of a particular outcome.\nA Naive Bayesian model is easy to build and useful for massive datasets. It's simple and is known to outperform even highly sophisticated classification methods." ;
        String prodDesc5 = "This algorithm can be applied to both classification and regression problems. Apparently, within the Data Science industry, it's more widely used to solve classification problems. It’s a simple algorithm that stores all available cases and classifies any new cases by taking a majority vote of its k neighbors. The case is then assigned to the class with which it has the most in common. A distance function performs this measurement.";
        String prodDesc6 = "It is an unsupervised learning algorithm that solves clustering problems. Data sets are classified into a particular number of clusters (let's call that number K) in such a way that all the data points within a cluster are homogenous and heterogeneous from the data in other clusters";
        String prodDesc7 = "A collective of decision trees is called a Random Forest. To classify a new object based on its attributes, each tree is classified, and the tree “votes” for that class. The forest chooses the classification having the most votes (over all the trees in the forest).";
        String prodDesc8 = "In today's world, vast amounts of data are being stored and analyzed by corporates, government agencies, and research organizations. As a data scientist, you know that this raw data contains a lot of information - the challenge is to identify significant patterns and variables.Dimensionality reduction algorithms like Decision Tree, Factor Analysis, Missing Value Ratio, and Random Forest can help you find relevant details.";
        String prodDesc9 = "Gradient Boosting Algorithm and AdaBoosting Algorithm are boosting algorithms used when massive loads of data have to be handled to make predictions with high accuracy. Boosting is an ensemble learning algorithm that combines the predictive power of several base estimators to improve robustness.";
        MyProduct prod0 = new MyProduct("Linear regression",                                         120,100, prodDesc0, 3, "product-1.jpg");
        MyProduct prod1 = new MyProduct("Logistic regression",                                       120,100, prodDesc1, 3, "product-2.jpg");
        MyProduct prod2 = new MyProduct("Decision tree",                                             220, 200, prodDesc2, 1, "product-3.jpg");
        MyProduct prod3 = new MyProduct("SVM algorithm",                                             420, 350, prodDesc3, 1, "product-4.jpg");
        MyProduct prod4 = new MyProduct("Naive Bayes algorithm",                                     220, 190, prodDesc4, 1, "product-5.jpg");
        MyProduct prod5 = new MyProduct("KNN algorithm",                                             220, 200, prodDesc5, 4, "product-6.jpg");
        MyProduct prod6 = new MyProduct("K-means",                                                   620, 540, prodDesc6, 2, "product-7.jpg");
        MyProduct prod7 = new MyProduct("Random forest algorithm",                                   320, 280, prodDesc7, 4, "product-8.jpg");
        MyProduct prod8 = new MyProduct("Dimensionality reduction algorithms",                       820, 780, prodDesc8, 1, "product-9.jpg");
        MyProduct prod9 = new MyProduct("Gradient boosting algorithm and AdaBoosting algorithm",     320, 280,prodDesc9, 1, "product-10.jpg");


        productRepository.save(prod0);
        productRepository.save(prod1);
        productRepository.save(prod2);
        productRepository.save(prod3);
        productRepository.save(prod4);
        productRepository.save(prod5);
        productRepository.save(prod6);
        productRepository.save(prod7);
        productRepository.save(prod8);
        productRepository.save(prod9);
        isInit = true;
    }
}
