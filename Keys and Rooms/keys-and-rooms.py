class Solution(object):
    def canVisitAllRooms(self, rooms):
        """
        :type rooms: List[List[int]]
        :rtype: bool
        """
        def dfs(rooms, visited, room):
            visited[room] = True
            for key in rooms[room]:
                if not visited[key]:
                    dfs(rooms, visited, key)

        n = len(rooms)
        visited = [False] * n
        dfs(rooms, visited, 0)
        return all(visited)
