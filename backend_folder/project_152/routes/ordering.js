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
    var foodName = req.body.foodName;
    var price = req.body.price;
    var quantity = req.body.quantity;
    newOrder.email = email;
    newOrder.firstname = firstname;
    newOrder.quantity = quantity;
    newOrder.currentUser = req.session.user['firstname'];
    newOrder.time = moment();
    newOrder.save(function(err,savedOrder){
        if(err){
            console.log(err);
            return res.json({"result":false, "message":"Failed to save order"});
        }
        return res.json({"result":true, "message":"Order is being processed!"});
    });

});

module.exports = router;