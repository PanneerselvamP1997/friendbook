import networkx as nx
from main.models import Quantified
import operator

G = nx.Graph()
if G.number_of_nodes() == 0:
	for user in Quantified.objects.all():
		G.add_node(user.userID)
if G.number_of_edges() == 0:
	users = Quantified.objects.all()
	num = G.number_of_nodes()
	for n in range(1, num+1):
		for i in range(1, n):
			if i == n:
				continue			
			G.add_edge(users[i-1].userID, users[n-1].userID, weight = 1.0)

def add_user(req_userID):
	G.add_node(req_userID)
	for other_user in Quantified.objects.all():
		if other_user.userID != req_userID:
			G.add_edge(req_userID, other_user.userID, weight = 1.0)

def update_edge(user1, user2, similarity_metric):
	G.add_edge(user1, user2, weight = similarity_metric)

def get_friends(req_userID):
	user_list = {req_userID:1}
	for other_user in Quantified.objects.all():
		if other_user.userID != req_userID:
			user_list[other_user.userID] = G.get_edge_data(req_userID, other_user.userID)['weight']
	sorted_user_list = sorted(user_list.items(), key = operator.itemgetter(1))
	##sorted_user_list[n][0] -> gives the nth key with lowest value
	u_list = [i[0] for i in sorted_user_list]
	return u_list[:6]
	#return user_list
	