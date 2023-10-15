# RPG Observer Game

quick game that simulates an RPG game to practice the Observer pattern. I know the main idea of this pattern is to determinate a one-to-many relationship and where Observable/Subject subscribes many observers so when a subject changes, it notifies all the observers to handle the state change.

But the examples of this pattern are almost such a tiny and quick demo, like simulate youtube video upload or something always one Subject and multiple Observers.

Real systems are much complicated than that, so let's deep dive into my game description on section below

## Domain Description  🀄

We have Warrior, Sellers, Boss and Npc's. Warrior's can fight against a Boss, more than one, it works like a coop RGB game, and when the boss finally die, he needs to notify players that fought against him that he died to increase the players gold and experience.

Sellers are merchants which sells a bunch of stuff like shields, poisons, weapons like swords, arrows, foods and more.

And a npc is a npc, non-playable-character.

It seems pretty easy at the first moment, at this point only warriors and boss needs to observe or notify something but i've complicated a bit.

At this moment, Boss is a subject who subscribe and notify players. The warriors are observers for boss, but when the sellers offers a discount for some product i want to notify all the subscribed players of this seller. So the warriors now are observing a Boss and Seller. Also a warrior can kill some npc, if so, the level of the warrior and of his partners will decrease, they'll turn themselves a disgraced warriors, so, if some warrior kills an npc, the npc needs to notify all the warriors that he died.

Until now, we have boss, npc and sellers as subject and a Warriors listening these three subjects. But now, the sellers can notify npc's from they offers as well. Therefore now, we have npc as observer of seller.

Each boss attack's some village, and when the warrior's kill the boss, all the villagers npc's  get a gold raise, so the warrior's that fought and killed the boss also needs to notify the npc's.

Therefore the relationship model finished like this:

- Warrior's are observers to Boss, Npc's and Seller's
- Npc is a Seller observer
- Npc's are a Warrior's observer

- Npc's, Seller's, Warrior's and Boss are Subject's
