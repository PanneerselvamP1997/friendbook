from django.shortcuts import render
from django.http import HttpResponse
from rest_framework.decorators import api_view
from rest_framework.response import Response
from rest_framework.parsers import JSONParser
from rest_framework.renderers import JSONRenderer
from api.serializers import DataLogSerializer, RegistrationSerializer
from api.models import UserData
from main import graph, engine


# Create your views here.
class JSONResponse(HttpResponse):
    def __init__(self, data, **kwargs):
        content = JSONRenderer().render(data)
        kwargs['content_type'] = 'application/json'
        super(JSONResponse, self).__init__(content, **kwargs)

@api_view(['POST'])
def datalog(request):
	if request.method == 'POST':
		data = JSONParser().parse(request)
        serializer = DataLogSerializer(data=data)
        if serializer.is_valid():
            serializer.save()
            #update('data', data['userID'])
            return JSONResponse(serializer.data, status=201)
        return JSONResponse(serializer.errors, status=400)


@api_view(['POST'])
def register(request):
	if request.method == 'POST':
		data = JSONParser().parse(request)
        serializer = RegistrationSerializer(data=data)
        if serializer.is_valid():
            serializer.save()
            #uid = update('reg', data['name'])
            return JSONResponse(serializer.data, status=201)
        return JSONResponse(serializer.errors, status=400)



@api_view(['GET'])
def get_friends(request, pk, format=None):
    if request.method == 'GET':
        u_list = graph.get_friends(pk)
        u_data = UserData.objects.values('name', 'fbid').filter(id__in=u_list)
        #serializer = UserDataSerializer(data=u_data)
        #if serializer.is_valid():
        return JSONResponse(u_data, status=201)
        #return JSONResponse(serializer.errors, status=400)        