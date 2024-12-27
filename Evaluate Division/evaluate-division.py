class Solution(object):
    def calcEquation(self, equations, values, queries):
        """
        :type equations: List[List[str]]
        :type values: List[float]
        :type queries: List[List[str]]
        :rtype: List[float]
        """
        def build_graph(equations, values):
            graph = {}
            for i, (dividend, divisor) in enumerate(equations):
                if dividend not in graph:
                    graph[dividend] = {}
                if divisor not in graph:
                    graph[divisor] = {}
                graph[dividend][divisor] = values[i]
                graph[divisor][dividend] = 1.0 / values[i]
            return graph
        
        def dfs(dividend, divisor, visited, graph, temp):
            if dividend not in graph or divisor not in graph:
                return -1.0
            if dividend == divisor:
                return temp
            visited.add(dividend)
            for neighbor, value in graph[dividend].items():
                if neighbor not in visited:
                    result = dfs(neighbor, divisor, visited, graph, temp * value)
                    if result != -1.0:
                        return result
            return -1.0
        
        graph = build_graph(equations, values)
        
        results = []
        for dividend, divisor in queries:
            results.append(dfs(dividend, divisor, set(), graph, 1.0))
        
        return results
