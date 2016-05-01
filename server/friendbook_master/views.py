from django.http import HttpResponse
import datetime

def hello(request):
	return HttpResponse("Welcome to FriendBook! :)")
