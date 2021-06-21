# Machine_coding

<h2>Problem statement 1:</h2>
<p>A cab company has the list of cab rides after it gets completed. After the journey both
cab driver and ride taker provide rating to each other. Rating can be from 1 to 5 where 5
is the best rating and 1 being the worst.
Given a Rider taker name, find the eligible cab drivers for him based on the historical
data that is being given to you. The criteria are given below to choose the eligible cab
drivers –<p>
  <ol>
  <li>Average rating of Cab driver should be greater than average rating of ride taker
(Choose with the highest rating).</li>
  <li>If no cab driver is found, then consider the best of all of them.</li>
  <li>If any cab driver has provided 1 rating to a ride taker or vice versa then they are
not allowed to do a ride together.</li>
</ol>.
<p>Ex: Input<br>
Ride data is given {Ride Taker Name, Rating given to Ride Taker, Driver Name, Rating
given to driver}<br>
Ride 1 – {Ram, 3, Bheem, 5}<br>
Ride 2 – {Laxman, 5, Nakul, 2}<br>
Ride 3 – {Ram, 4, Sahadev, 2}<br>
Ride 4 – {Bharat, 3, Bheem, 5}<br>
Ride 5 – {Ram, 3, Bheem, 1}<br>
Ride 6 – {Laxman, 5, Sahadev, 3}<br>
Ride 7 – {Bharat, 5, Nakul, 5}<br>
Find eligible drivers for:<br>
Eg:<br>
1. Ram<br>
2. Laxman<br>
Output:<br>
1. Nakul<br>
2. Bheem<br>

</p>



<h2>Problem statement 2:</h2>
<p>You are given an input integer N which is the number of teams in a cricket tournament.
For each team, first, you will be given with Team Name and then K, which is the number
of players in that team. Now next K lines contain playerNames. The team will then be
provided with total points<p>
<p>Your job is to print the name of first-team on the leaderboard.<p>
<p>Ex: Input
3<br>
INDIA 4<br>
VIRAT<br>
DHONI<br>
SEHWAG<br>
BHAJJI<br>
1<br>
AUSTRALIA 3<br>
PONTING<br>
SYMONDS<br>
SMITH<br>
3<br>
ENGLAND 2<br>
MORGAN<br>
BUTLER<br>
2</p>
<p>Output:
AUSTRALIA<p>
