# Lebesgue’s Universal Covering Problem

The Lebesgue universal covering problem. Philip Gibbs [code](http://math.ucr.edu/home/baez/mathematical/lebesgue.java) to compute the area for many choices of rotation angle.  

## About

In 1914 [Henri Lebesgue](https://en.wikipedia.org/wiki/Henri_Lebesgue) defined a **'universal covering'** to be a convex subset
of the plane that contains an isometric copy of any subset of **diameter 1.** 
His challenge of finding a universal covering with the least possible area has been addressed by various mathematicians: [Pál](https://en.wikipedia.org/wiki/Pál_Turán), Sprague and H.C Hansen have each created a smaller universal covering by removing regions from those known before.  However, Hansen's last reduction was microsopic: he claimed to remove an area of 6⋅10−18, but we show that he actually removed an area of just 8⋅10−21.  In the following, with the help of Greg Egan, we find a new, smaller universal covering with area less than 0.8441153. This reduces the area of the previous best universal covering by 2.2⋅10−5.

The program is not very long. Please study it, add some test cases to this program or write your own, in your own favorite language! 

The output of the program is here:

```
	------------------	-----------------	------------------
	|      Area      |     	|    Angle 1    |   	|     Angle 2    |
	------------------	-----------------	------------------
0	0.8441281473635023	88.60789390240575	124.70567493165655
0.1	0.8441249398973186	88.71714220899656	124.56695879567842
0.2	0.8441221028463506	88.8260964414572	124.4285772267079
0.3	0.8441196363224983	88.93475925216121	124.29052749390299
0.4	0.8441175404406899	89.04313328141143	124.15280687881696
0.5	0.8441158153188825	89.15122115749935	124.0154126753377
0.6	0.8441144610780628	89.25902549676582	123.87834218962644
0.7	0.8441134778422481	89.36654890366236	123.74159274005537
0.8	0.8441128657384852	89.47379397081467	123.60516165714331
0.9	0.844112624896854	89.58076327908488	123.4690462834925
1	0.8441127554504655	89.68745939763818	123.33324397372115
1.1	0.8441132575354651	89.79388488400514	123.19775209440034
1.2	0.8441141312910305	89.90004228415069	123.062568023984
1.3	0.8441153768593765	90.00593413254083	122.9276891527414
1.4	0.8441169943857526	90.11156295220835	122.79311288269056
1.5	0.8441189840184462	90.21693125482504	122.6588366275253
1.6	0.8441213459087822	90.32204154076746	122.52485781254855
1.7	0.8441240802111265	90.42689629918976	122.3911738745986
1.8	0.8441271870828845	90.53149800809305	122.2577822619791
1.9	0.8441306666845043	90.63584913439738	122.12468043438602
2	0.8441345191794781	90.73995213401359	121.99186586283525

--------------------------------------------------------------------------
|                       Table of H.C Hansen values                       |
--------------------------------------------------------------------------


0	0.1339745962155614	4.952913815765206E-4
1	0.024131160666459442	2.418850424554875E-6
2	6.080990483914671E-4	3.750723412842599E-11
3	3.701744790810228E-7	8.454119457933276E-21
4	1.3702923282072605E-13	4.288332272808866E-40
5	1.87770106474412E-26	1.103387620921236E-78
6	3.5257612885412026E-52	7.304785452013354E-156

```


## Read more

* [Lebesgue’s Universal Covering Problem (Part 1 - 2013)](https://johncarlosbaez.wordpress.com/2013/12/08/lebesgues-universal-covering-problem/)
* [Lebesgue’s Universal Covering Problem (Part 2 - 2015)](https://johncarlosbaez.wordpress.com/2015/02/03/lebesgues-universal-covering-problem-part-2/)
* [Lebesgue’s Universal Covering Problem (Part 3 - 2018)](https://johncarlosbaez.wordpress.com/2018/10/07/lebesgue-universal-covering-problem-part-3/)
* [A lower bound for Lebesgue's universal cover problem (Peter Brass and Mehrnod Sharifi - 2005)](http://www.cs.cmu.edu/~mehrbod/UC05.pdf)
* [The Lebesgue universal covering problem (John C. Baez, Karine Bagdasaryan, Philip Gibbs - 2015)](http://jocg.org/v6n1p12)
* [An upper bound for Lebesgue’s universal covering problem (Philip Gibbs - 2018)](http://vixra.org/abs/1801.0292)
* [Amateur Mathematician Finds Smallest Universal Cover (Popular article on this topic)](https://www.quantamagazine.org/amateur-mathematician-finds-smallest-universal-cover-20181115/)

