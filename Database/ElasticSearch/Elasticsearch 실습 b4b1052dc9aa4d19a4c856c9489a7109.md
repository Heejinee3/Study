# Elasticsearch 실습

- CRUD API
    - index API
        - 문서 생성/전체 수정
        
        ```json
        PUT my_index/_doc/1
        {
          "message": "hello"
        }
        ```
        
        - 문서 생성 (랜덤 id 지정)
        
        ```json
        POST my_index/_doc
        {
          "message": "hello"
        }
        ```
        
        - 문서 생성
        
        ```json
        POST my_index/_create/1
        {
          "message": "hello"
        }
        ```
        
        ```json
        PUT my_index/_create/1
        {
          "message": "hello"
        }
        ```
        
    - get API
        - 문서 조회 (메타데이터 포함)
        
        ```json
        GET my_index/_doc/1
        ```
        
        - 문서 조회 (메타데이터 미포함)
        
        ```json
        GET my_index/_source/1
        ```
        
    - update API
        - 문서 부분 수정
        
        ```json
        POST my_index/_update/1
        {
          "doc": {
            "message":"hello!!"
          }
        }
        ```
        
    - delete API
        - 문서 삭제
        
        ```json
        DELETE my_index/_doc/1
        ```
        
- bulk API
    - 종류: index, create, update, delete
    - application/x-ndjson 사용
    
    ```json
    POST _bulk
    {"index":{"_index":"my_index", "_id":"1"}}
    {"message":"hello"}
    {"index":{"_index":"my_index", "_id":"2"}}
    {"message":"hello"}
    {"delete":{"_index":"my_index", "_id":"2"}}
    {"create":{"_index":"my_index", "_id":"3"}}
    {"message":"hello"}
    {"update":{"_index":"my_index", "_id":"1"}}
    {"doc":{"message":"hello!!"}}
    ```
    
    ```jsx
    POST my_index/_bulk
    {"index":{"_id":"1"}}
    {"message":"hello"}
    {"index":{"_id":"2"}}
    {"message":"hello"}
    {"delete":{"_id":"2"}}
    {"create":{"_id":"3"}}
    {"message":"hello"}
    {"update":{"_id":"1"}}
    {"doc":{"message":"hello!!"}}
    ```
    
- multi get API
    
    ```jsx
    GET _mget
    {
      "docs":[
        {
          "_index": "my_index",
          "_id": 1,
          "_source": {
            "include": ["field1"],
            "exclude": ["field2"]
          }
        },
        {
          "_index": "my_index",
          "_id": 2,
          "_source": {
            "include": ["field1"],
            "exclude": ["field2"]
          }
        }
      ]
    }
    ```
    
    ```jsx
    GET my_index/_mget
    {
      "docs":[
        {
          "_id": 1,
          "_source": {
            "include": ["field1"],
            "exclude": ["field2"]
          }
        },
        {
          "_id": 2,
          "_source": {
            "include": ["field1"],
            "exclude": ["field2"]
          }
        }
      ]
    }
    ```
    
- search API
    - 종류
        - 쿼리 문자열 검색
        
        ```json
        GET my_index/_search?q=message:hello
        ```
        
        - 쿼리 DSL 검색
        
        ```json
        GET my_index/_search
        {
          "query": {
            "match": {
              "message": "hello"
            }
          }
        }
        ```
        
    - 검색 대상 지정
        
        ```jsx
        GET my_index/_search
        ```
        
        ```jsx
        POST my_index/_search
        ```
        
        ```jsx
        GET _search
        ```
        
        ```jsx
        POST _search
        ```
        
        ```jsx
        GET my_index1,my_index2/_search
        ```
        
    - query context, filter context
        
        
        |  | query context | filer context |
        | --- | --- | --- |
        | score | 계산함 | 계산하지 않음 |
        | 성능 | 상대적으로 느림 | 상대적으로 빠름 |
        | 종류 | must, should, match, term 등 | filter, must_not, exists, range, constant_score 등 |
    - match_all
        - 전체 검색
        
        ```jsx
        POST my_index/_search
        {
          "query": {
            "match_all": {}
          }
        }
        ```
        
    - match
        - 질의어와 매치되는 문서를 찾는 쿼리
        
        ```jsx
        // OR 조건
        GET my_index/_search
        {
          "query": {
            "match": {
              "message": {
                "query": "hello gildong"
              }
            }
          }
        }
        ```
        
        ```jsx
        // AND 조건
        GET my_index/_search
        {
          "query": {
            "match": {
              "message": {
                "query": "hello gildong",
                "operator": "and"
              }
            }
          }
        }
        ```
        
    - term
        - 지정한 필드의 값이 질의어와 정확히 일치하는 문서를 찾는 쿼리
        
        ```jsx
        GET my_index/_search
        {
          "query": {
            "term": {
              "message": {
                "value": "hello"
              }
            }
          }
        }
        ```
        
    - terms
        - term과 유사하며, 질의어를 여러개 지정할 수 있는 쿼리
        
        ```jsx
        GET my_index/_search
        {
          "query": {
            "terms": {
              "message": ["hi", "hello"]
            }
          }
        }
        ```
        
    - range
        - 지정한 필드의 값이 특정 범위 내에 있는 문서를 찾는 쿼리
        - 종류: gt, lt, gte, lte
        
        ```jsx
        GET my_index/_search
        {
          "query": {
            "range": {
              "send_date": {
                "gte": "2024-01-01T00:00:00.000Z::+36h/d",
                "lte": "now-3h/d"
              }
            }
          }
        }
        ```
        
    - prefix
        - 필드의 값이 지정한 질의어로 시작하는 문서를 찾는 쿼리
        - 일상적으로 호출되는 서비스성 쿼리로는 적절하지 못함
        
        ```jsx
        GET my_index/_search
        {
          "query": {
            "prefix": {
              "message": {
                "value": "hello"
              }
            }
          }
        }
        ```
        
        - prefix 쿼리를 서비스 호출 용도로 사용하려 한다면 매핑에 index_prefixes 설정을 넣는 방법 존재
        - 문서를 색인할 때, min_chars와 max_chars 사이의 prefix를 미리 별도 색인
        
        ```jsx
        PUT my_index
        {
          "mappings": {
            "properties": {
              "message": {
                "type": "text",
                "index_prefixes":{
                  "min_chars": 3,
                  "max_chars": 5
                }
              }
            }
          }
        }
        ```
        
    - exists
        - 지정한 필드를 포함한 문서를 찾는 쿼리
        
        ```jsx
        GET my_index/_search
        {
          "query": {
            "exists": {
              "field": "message"
            }
          }
        }
        ```
        
    - must
        - 하위 쿼리가 모두 AND 조건으로 만족해야 최종 검색 결과에 포함됨
        - score를 매긴다는 점에서 filter와 다른 점
        
        ```jsx
        GET my_index/_search
        {
          "query": {
            "bool":{
              "must": [
                { "term": { "message": { "value": "hello"} } },
                { "term": { "message": { "value": "gildong"} } }
              ]
            }
          }
        }
        ```
        
    - must_not
        - 하위 쿼리를 만족하는 문서는 최종 검색 결과에서 제외됨
        
        ```jsx
        GET my_index/_search
        {
          "query": {
            "bool":{
              "must_not": [
                { "term": { "message": { "value": "hi"} } },
                { "term": { "message": { "value": "gildong"} } }
              ]
            }
          }
        }
        ```
        
    - filter
        - 하위 쿼리가 모두 AND 조건으로 만족해야 최종 검색 결과에 포함됨
        - score를 매기지 않는다는 점에서 must와 다른 점
        
        ```jsx
        GET my_index/_search
        {
          "query": {
            "bool":{
              "filter": [
                { "term": { "message": { "value": "hello"} } },
                { "term": { "message": { "value": "gildong"} } }
              ]
            }
          }
        }
        ```
        
    - should
        - minimum_should_match에 지정한 개수 이상의 하위 쿼리를 만족하는 문서가 최종 검색 결과에 포함됨
        - 하위 쿼리를 만족하는 문서의 score를 높이는 용도로도 사용
        
        ```jsx
        GET my_index/_search
        {
          "query": {
            "bool":{
              "should": [
                { "term": { "message": { "value": "hello"} } },
                { "term": { "message": { "value": "gildong"} } }
              ],
              "minimum_should_match": 1 // 지정한 개수 이상의 하위 쿼리를 만족하는 문서가 최종 검색 결과에 포함됨
                                        // 검색조건에 should만 있으면 minimum_should_match 값이 default로 1이고, 그렇지 않으면 0
            }
          }
        }
        ```
        
    - constant_score
        - 하위 filter 부분에 지정한 쿼리에  score를 정하고 싶을 때 사용
        
        ```jsx
        GET my_index/_search
        {
          "query": {
            "constant_score": {
              "filter": {
                "term": { "message": "hello" }
              },
              "boost": 1.2
            }
          }
        }
        ```
        
- sort API
    - 필드의 값을 기준으로 도큐먼트를 정렬할 때 사용
    
    ```jsx
    GET my_index/_search
    {
      "query": {
        "match": {
          "message": {
            "query": "hello"
          }
        }
      },
      "sort" : [
        { "message.keyword" : { "order" : "asc" } }, // 숫자, date, boolean, keyword, _score, _doc 사용 가능
        "_score",                                    // text는 사용 불가능
        "_doc"
      ]
    }
    ```
    
- pagination API
    - from
        - 몇 번째 문서부터 몇 개의 문서를 반환하고 싶을 때 사용
        
        ```jsx
        GET my_index/_search
        {
          "from": 7, // 몇 번째 문서부터 결과를 반환할지 offset 지정 (from 값이 올라갈수록 무거운 검색을 수행)
          "size": 3, // 몇 개의 문서를 반환할 것인지 지정
          "query": {
            "match": {
              "message": {
                "query": "hello"
              }
            }
          }
        }
        ```
        
    - scroll
        - 검색 조건에 매칭되는 전체 문서를 모두 순회해야 할 때 사용
        
        - 첫 번째 검색
        
        ```jsx
        GET my_index/_search?scroll=2m // 검색 문맥의 유지 시간은 배치와 배치 사이를 유지할 정도의 시간으로 지정
        {
          "size": 3,
          "query": {
            "match": {
              "message": {
                "query": "hello"
              }
            }
          }
        }
        ```
        
        - 첫 번째를 제외한 검색
        
        ```jsx
        GET _search/scroll
        {
          "scroll_id": "FGluY2x1ZGVfY29udGV4dF91dWlkDXF1ZXJ5QW5kRmV0Y2gBFktkTTJPVUpmVG0tX1FVdjFJUjdXdncAAAAAAABC3BZXNWxnaXNmS1NLT3RiVTFPSXBNbk5B",
          "scroll": "2m"
        }
        ```
        
        - 명시적으로 삭제
        
        ```jsx
        DELETE _search/scroll
        {
          "scroll_id": "FGluY2x1ZGVfY29udGV4dF91dWlkDXF1ZXJ5QW5kRmV0Y2gBFktkTTJPVUpmVG0tX1FVdjFJUjdXdncAAAAAAABC3BZXNWxnaXNmS1NLT3RiVTFPSXBNbk5B",
        }
        ```
        
    - search_after
        - 서비스에서 사용자가 검색 결과를 요청케 하고 결과에 페이지네이션을 제공하는 용도로 사용
        
        ```jsx
        GET my_index/_search
        {
          "size": 3,
          "search_after": ["4fa8b6c3-e042-436f-b703-74ef3870d7be"], // 해당 도큐먼트의 sort값을 넣으면 다음 도큐먼트부터 search
          "query": {
            "match": {
              "message": {
                "query": "hello"
              }
            }
          },
          "sort" : [ // 동일한 정렬 값이 등장할 수 없도록 최소한 1개 이상의 동점 제거용 필드를 지정해야 함
            "uuid"   // 단, _id는 doc_values가 꺼져 있어서 많은 메모리를 사용
          ]
        }
        ```
        
        - pit을 이용한 search
        - 인덱스 상태를 특정 지점으로 고정
        
        - 처음에 pit 설정하여 상태 고정
        
        ```jsx
        // keep_alive: 상태 유지 시간
        POST my_index/_pit?keep_alive=5m
        ```
        
        - pit을 설정한 이후 search
        
        ```jsx
        // index 지정 필요 없음
        // sort에 *_*shard_doc이 추가되기 때문에 동점 제거용 필드를 지정할 필요 없음
        GET _search
        {
          "size": 3,
          "query": {
            "match": {
              "message": {
                "query": "hello"
              }
            }
          },
          "pit": {
            "id": "uMyMBAEIbXlfaW5kZXgWYWJUZG5STTdRd3VJQUd2UzNDNEZjQQAWVzVsZ2lzZktTS090YlUxT0lwTW5OQQAAAAAAAABHcBZLZE0yT1VKZlRtLV9RVXYxSVI3V3Z3AAEWYWJUZG5STTdRd3VJQUd2UzNDNEZjQQAA",
            "keep_alive": "5m"
          }, 
          "search_after": ["hello", 4], 
          "sort" : [
            "message.keyword"
          ]
        }
        ```
        
        - 명시적 삭제
        
        ```jsx
        DELETE _pit
        {
        	"id": "uMyMBAEIbXlfaW5kZXgWYWJUZG5STTdRd3VJQUd2UzNDNEZjQQAWVzVsZ2lzZktTS090YlUxT0lwTW5OQQAAAAAAAABHcBZLZE0yT1VKZlRtLV9RVXYxSVI3V3Z3AAEWYWJUZG5STTdRd3VJQUd2UzNDNEZjQQAA"
        }
        ```
        
- aggregation API
    - metric
        - 종류:  avg, max, min, sum, stats, cardinality
        - cardinality는 근사값이며, precision_threshold를 통해 정확도를 높일 수 있음 (precision_threshold가 최종 cardinality보다 높으면 정확도가 충분히 높음)
        
        ```jsx
        GET my_index/_search
        {
          "size": 0,
          "query": {
            "match": {
              "message": {
                "query": "hello"
              }
            }
          },
          "aggs": {
            "my_aggregation": {
              "sum": {
                "field": "time"
              }
            }
          }
        }
        ```
        
    - bucket
        - range
            - 지정한 필드값을 기준으로 문서를 원하는 버킷 구간으로 쪼갬
            
            ```jsx
            GET my_index/_search
            {
              "size": 0,
              "query": {
                "match": {
                  "message": {
                    "query": "hello"
                  }
                }
              },
              "aggs": {
                "my_aggregation": {
                  "range": {
                    "field": "time",
                    "ranges": [
                      { "to": 200 },
                      { "from": 200, "to": 400 },
                      { "from": 400 }
                    ]
                  },
                  "aggs": {
                    "my_sum": {
                      "sum": {
                        "field": "time"
                      }
                    }
                  }
                }
              }
            }
            ```
            
        - date_range
            - range와 유사하나 date 타입 필드를 대상으로 사용
            
            ```jsx
            GET my_index/_search
            {
              "size": 0,
              "query": {
                "match": {
                  "message": {
                    "query": "hello"
                  }
                }
              },
              "aggs": {
                "my_aggregation": {
                  "date_range": {
                    "field": "date",
                    "format": "MM-yyyy",
                    "ranges": [
                      { "to": "now-2M" },
                      { "from": "now-2M", "to": "now" },
                      { "from": "now" }
                    ]
                  },
                  "aggs": {
                    "my_sum": {
                      "sum": {
                        "field": "time"
                      }
                    }
                  }
                }
              }
            }
            ```
            
        - histogram
            - range와 비슷하나, 버킷의 간격을 지정해서 경계를 나눔
            - min_doc_count 지정 가능 (버킷 내 문서 개수가 일정 이하인 버킷은 결과에서 제외)
            
            ```jsx
            GET my_index/_search
            {
              "size": 0,
              "query": {
                "match": {
                  "message": {
                    "query": "hello"
                  }
                }
              },
              "aggs": {
                "my_aggregation": {
                  "histogram": {
                    "field": "time",
                    "interval": 200,
                    "offset": 100
                  },
                  "aggs": {
                    "my_sum": {
                      "sum": {
                        "field": "time"
                      }
                    }
                  }
                }
              }
            }
            ```
            
        - date_histogram
            - histogram과 비슷하나 date 타입 필드를 대상으로 사용
            - calendar_interval, fixed_interval 사용
            
            | calendar_interval | fixed_interval |
            | --- | --- |
            | minute, 1m | milliseconds (ms) |
            | hour, 1h | seconds (s) |
            | day, 1d | minutes (m) |
            | month, 1M | hours (h) |
            | quarter, 1q | days (d) |
            | year, 1y |  |
            
            ```jsx
            // offset, min_doc_count 지정 가능
            GET my_index/_search
            {
              "size": 0,
              "query": {
                "match": {
                  "message": {
                    "query": "hello"
                  }
                }
              },
              "aggs": {
                "my_aggregation": {
                  "date_histogram": {
                    "field": "date",
                    "calendar_interval": "1M"
                  },
                  "aggs": {
                    "my_sum": {
                      "sum": {
                        "field": "time"
                      }
                    }
                  }
                }
              }
            }
            ```
            
        - terms
            - 지정한 필드에 대해 가장 빈도수가 높은 term 순서대로 버킷 생성
            - 결과가 정확하지 않을 수 있음
            - 응답에 나타나는 doc_count_error_upper_bound는 doc_count의 오차 상한을 나타냄
            - 응답에 나타나는 sum_other_doc_count는 최종적으로 버킷에 포함되지 않은 문서 수를 나타냄
            
            ```jsx
            GET my_index/_search
            {
              "size": 0,
              "query": {
                "match": {
                  "message": {
                    "query": "hello"
                  }
                }
              },
              "aggs": {
                "my_aggregation": {
                  "terms": {
                    "field": "message.keyword", // text는 일반적으로 사용 불가
                    "size": 10 // 버킷을 몇 개까지 생성할 것인지 지정
                  },
                  "aggs": {
                    "my_sum": {
                      "sum": {
                        "field": "time"
                      }
                    }
                  }
                }
              }
            }
            ```
            
        - composite
            - sources로 지정된 하위 집계의 버킷 전부를 페이지네이션을 이용해 효율적으로 순회하는 집계
            
            ```jsx
            GET my_index/_search
            {
              "size": 0,
              "query": {
                "match": {
                  "message": {
                    "query": "hello" 
                  }
                }
              },
              "aggs": {
                "my_aggregation": {
                  "composite": {
                    "size": 2, // 몇 개의 버킷을 반환할 지 지정
                    "sources": [
                      {
                        "histo_aggs": {
                          "histogram": {
                            "field": "time",
                            "interval": 200
                          }
                        }
                      },
                      {
                        "date_histo_aggs": {
                          "date_histogram": {
                            "field": "date",
                            "calendar_interval": "1M"
                          }
                        }
                      }
                    ],
                    "after": { // 작업 결과의 다음 페이지 조회
                      "histo_aggs": 200,
                      "date_histo_aggs": 1706745600000
                    }
                  },
                  "aggs": {
                    "my_sum": {
                      "sum": {
                        "field": "time"
                      }
                    }
                  }
                }
              }
            }
            ```
            
    - pipeline
        - cumulative_sum
            - 다른 집계의 값을 누적하여 합산
            - buckets_path를 지정할 때 사용할 수 있는 구문
                
                
                | > | 하위 집계로 이동하는 구분자 |
                | --- | --- |
                | . | 하위 메트릭으로 이동하는 구분자 |
                | 집계 이름 |  |
                | 메트릭 이름 |  |
            
            ```jsx
            GET my_index/_search
            {
              "size": 0,
              "query": {
                "match": {
                  "message": {
                    "query": "hello"
                  }
                }
              },
              "aggs": {
                "my_aggregation": {
                  "histogram": {
                    "field": "time",
                    "interval": 200,
                    "offset": 100
                  },
                  "aggs": {
                    "my_sum": {
                      "sum": {
                        "field": "time"
                      }
                    },
                    "my_cum_sum":{
                      "cumulative_sum": {
                        "buckets_path": "my_sum" // 누적 합산할 집계의 이름 지정
                      }
                    }
                  }
                }
              }
            }
            ```
            
        - max_bucket
            - 다른 집계의 결과를 받아서 그 결과가 가장 큰 버킷의 key와 결과값을 구하는 집계
            
            ```jsx
            GET my_index/_search
            {
              "size": 0,
              "query": {
                "match": {
                  "message": {
                    "query": "hello"
                  }
                }
              },
              "aggs": {
                "my_aggregation": {
                  "histogram": {
                    "field": "time",
                    "interval": 200,
                    "offset": 100
                  },
                  "aggs": {
                    "my_sum": {
                      "sum": {
                        "field": "time"
                      }
                    }
                  }
                },
                "my_max_bucket":{
                  "max_bucket": {
                    "buckets_path": "my_aggregation>my_sum" // 결과가 가장 큰 버킷을 구할 집계의 이름 지정
                  }
                }
              }
            }
            ```
            

[Document APIs | Elasticsearch Guide [8.13] | Elastic](https://www.elastic.co/guide/en/elasticsearch/reference/current/docs.html)

[Query DSL | Elasticsearch Guide [8.13] | Elastic](https://www.elastic.co/guide/en/elasticsearch/reference/current/query-dsl.html)

---

| y | 연도 |
| --- | --- |
| M | 월 |
| w | 주 |
| d | 날짜 |
| h | 시간 |
| H | 시간 |
| m | 분 |
| s | 초 |

now: 현재시간

||: 날짜 시간 문자열의 마지막에 붙임,이 뒤의 붙는 문자열은 시간 계산식으로 파싱

+, -: 더하기 빼기 연산

/: 버림 

```jsx
PUT my_index
{
  "mappings": {
    "properties": {
      "message": {
	      "type": "text",
	       "fields": {
            "keyword": {
              "type": "keyword",
              "ignore_above": 256
            }
          }
      },
      "time":{
	      "type": "long"
      },
      "date": {
        "type": "date",
        "format": "yyyy-MM-dd HH:mm:ss||yyyy/MM/dd||epoch_millis"
      }
    }
  }
}
```

```jsx
POST my_index/_doc
{
  "message": "hello",
  "time": 500,
  "date": "2024-05-01 00:00:00"
}
```