# PlantsVsZombies

## Interfaces Required:
1. Attacking (for Plant, Zombie)
2. Hiding (for Plant)
3. Clonable (for Zombie, Projectile)
4. Plantable (for Plant (lilypad, flowerpot), Tile)
5. Growable (for Plant)
6. DayTime (tagging)
7. NightTime (tagging)
8. Suntype
9. Freezing

## Basic Classes Required (assume Constructor exists):
1. Plants (abstract)
    - HP
    - XP defining size
    - Attack_value
    - SunPower
    - Position
    - Wait_time
    - Range
    - Attack_Interval
    - Plant() method
2. Plant_Type (extends Plants)
    - Additional HP
    - Additional Attack
    - implements Attacking?
    - implements Hiding?
    - implements Growable?
    - implements Suntype?
    - implements Freezing?
    - implements DayTime/NightTime/both?
    - implements Plantable?
    - implements SunType?
    - (Image) plantAppearance
    - Projectile (if Attacking)
    - Plant() method (partial overriding)
3. Sun
    - sunAmount
    - timeAvailable
    - Image sunAppearance
    - fall(row,column) method
    - appear(row,column) method
4. Lawnmower
    - Row
    - (Image) lmAppearance
    - killAll() method
5. Zombies (abstract)
    - implements Attacking
    - Attack_value
    - Position
    - Attack_interval
    - Attack() method
    - Move() method
    - isAttacked() method
6. Zombie Type
    - HP
    - implements Clonable?
    - (Image) zombieAppearance
7. Tile
    - rowPos
    - columnPos
8. Tile Type
    - implements Plantable?
    - (image) tileAppearance
    - Plant object (if Plantable)
    - Plant() method (in Plantable)
9. User
    - MoneyEarned
    - Levels Played
    - User Name
    - Plants Catalog
    - Zombie Catalog
    - chooseLevel() method
    - playLevel() method
    - buyPlant() method
10. Level
    - Tile[][] PlayArea
    - Plants[][] Planted
    - Zombies[] distribution
    - Lawnmowers[] available
11. Game
    - User[] List
    - User inUse
    - Inner Class Sidebar
    - Inner Class Zombies left progress bar
    - playGame() method
    - levelWon() method
    - levelLost() method