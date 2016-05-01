from main.models import Quantified, Exercise
from api.models import UserData, DataLog
import datetime, decimal
from main import graph


def match(req_userID):
	user = Quantified.objects.filter(userID=req_userID)
	all_users = Quantified.objects.all()
	for other_user in all_users:
		if other_user.userID != req_userID:
			similarity_metric = decimal.Decimal(abs(user[0].exercise - other_user.exercise) + abs(user[0].read - other_user.read) + abs(user[0].travel - other_user.travel) + abs(user[0].film - other_user.film) + abs(user[0].social - other_user.social))/5
			graph.update_edge(req_userID, other_user.userID, similarity_metric)

def quantify_exercise(req_userID):
	end_date = datetime.datetime.today()
	start_date = end_date - datetime.timedelta(days = 30)
	n_run = 0
	n_walk = 0
	n_gym = 0
	dur = datetime.timedelta(0)
	for exe in Exercise.objects.filter(userID__exact = req_userID, timestamp__range=(start_date, end_date)):
		if exe.event == 'run':
			n_run += 1
		elif exe.event == 'walk':
			n_walk += 1
		elif exe.event == 'gym':
			n_gym += 1
		dur += exe.duration
	days, seconds = dur.days, dur.seconds
	hours = decimal.Decimal(days * 24 + seconds / 3600)
	quantified = (decimal.Decimal(n_gym)/decimal.Decimal('30') + decimal.Decimal(n_walk)/decimal.Decimal('30') + decimal.Decimal(n_run)/decimal.Decimal('30') + hours/decimal.Decimal('30'))/decimal.Decimal('4')
	Quantified.objects.filter(userID=req_userID).update(exercise = quantified)
	match(req_userID)


def update(type_, req_userID):
	if type_ == 'data':
		#update relevant model in main

def quantify_read(req_userID):
	#algorithm to quanitfy reading lifestyle with the relevant data
