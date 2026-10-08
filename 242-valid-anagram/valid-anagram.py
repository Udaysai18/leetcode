class Solution(object):
    def isAnagram(self, s, t):  
        if(sorted(s.lower()) == sorted(t.lower())):
            return True
        else:
            return False
        