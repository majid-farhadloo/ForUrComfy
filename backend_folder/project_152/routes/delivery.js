var express = require('express');
var router = express.Router();
var order = require('../lib/order')
// var md5= require('md5');
var mongoose = require('mongoose');
var moment = require('moment');

mongoose.connect("mongodb://heroku_vtkwsl62:1234qwer@ds235778.mlab.com:35778/heroku_vtkwsl61");
var db = mongoose.connection;
db.once("open",function() {
    console.log("DB connected!");
});
db.on("error", function (err) {
    console.log("DB ERROR :", err);
});

// var query = order.find({});
// console.log(query['foodName']);

router.get('/', function(req, res) {
    order.find({completed:false}, function(err, result) {
    if (err) throw err;
    //  {
    //     "_id": "5ad524b4a5e9280649091d82",
    //     "foodName": "kungpao chicken",
    //     "price": 5.99,
    //     "quantity": 2,
    //     "currentUser": "Calvin",
    //     "time": "Mon Apr 16 2018 15:33:24 GMT-0700",
    //     "__v": 0
    // },
    // res.send('respond with a resource');
    // var user  = req.session.user;
    });
  });

module.exports = router;
