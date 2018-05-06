var express = require('express');
var router = express.Router();
var order = require('../lib/order')
// var md5= require('md5');
var mongoose = require('mongoose');
var moment = require('moment');



//CONNECT TO DATABASE
mongoose.connect("mongodb://heroku_vtkwsl62:1234qwer@ds235778.mlab.com:35778/heroku_vtkwsl61");
var db = mongoose.connection;
db.once("open",function() {
    console.log("DB connected!");
});
db.on("error", function (err) {
    console.log("DB ERROR :", err);
});

/* GET users listing. */
router.post('/', function(req, res) {
    // res.send('respond with a resource');
    // var user  = req.session.user;
    var newOrder = new order();
    var food = req.body.food;
    var price = req.body.price;
    var quantity = req.body.quantity;
    var name = req.body.name;
    var location = req.body.location;
    var cell = req.body.cell;

    newOrder.food = food;
    newOrder.name = name;
    newOrder.time = Date.now();
    newOrder.completed = false;
    newOrder.location = location;
    newOrder.cell = cell;
    newOrder.save(function(err,savedOrder){
        // if(!req.session.user)
        // {
        //   return res.json({"result":false, "message":"User not logged in"});
        // }
        if(err){
            console.log(err);
            return res.status(400).json({"result":false, "message":"Failed to save order"});
        }
        return res.status(200).json({"result":true,
                          "message":"Order is being processed!",
                          "Order ID":savedOrder['_id'],
                          "Deliver to":savedOrder['location'],
                          "Food details":savedOrder['food']//['foodName']+","+ savedOrder.food['quantity']+","+ savedOrder.food['price']
                        });
    });

});

module.exports = router;
