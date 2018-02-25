var express = require('express');
var router = express.Router();
var User = require('../models/user');

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});

router.post('/regist', fuinction(req, res, next){
	var user = new User();
	user.email = req.body.email;
	user.passwd = req.body.passwd;
	user.cell = req.body.cell;
	user.fname = req.body.fname;
	user.lname = req.body.lname;

	user.save(function (err) {
		if(err) {
			console.log(err);
			res.json({result: 0});
			return;
		}
		res.json({result: 1});
	})
});

router.get('/get', function (req, res) {
	User.find(function (err, users) {
		if(err) return res.status(500).send({error: 'database find failure'});
		res.json(users);
	})
})

router.get('/get/email/:email', function(req, res) {
	User.findOne({email: req.params.email}, function (err, user) {
		console.log(req.params.email);
			if(err) return res.status(500).send({error: 'database find failure'});
			if(!user)
	})
})
module.exports = router;
