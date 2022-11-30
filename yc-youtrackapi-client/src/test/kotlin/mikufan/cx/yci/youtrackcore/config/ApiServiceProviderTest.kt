package mikufan.cx.yci.youtrackcore.config

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.types.shouldBeInstanceOf
import mikufan.cx.yci.youtrackcore.api.issues.IssuesApi
import mikufan.cx.yci.youtrackcore.util.YOUTRACK_TEST_BEARER_TOKEN
import mikufan.cx.yci.youtrackcore.util.YOUTRACK_TEST_URI
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.web.reactive.function.client.WebClient

@SpringBootTest
class ApiServiceProviderTest(
  private val webClientProvider: WebClientProvider,
  private val apiServiceProvider: ApiServiceProvider,
) : ShouldSpec({
  context("get api service") {
    should("get api service by method") {
      apiServiceProvider.issuesApi(YOUTRACK_TEST_URI, YOUTRACK_TEST_BEARER_TOKEN).shouldBeInstanceOf<IssuesApi>()
      apiServiceProvider.issuesApi(YOUTRACK_TEST_URI, YOUTRACK_TEST_BEARER_TOKEN).shouldBeInstanceOf<IssuesApi>()
      webClientProvider.getWebClient(YOUTRACK_TEST_URI, "123").shouldBeInstanceOf<WebClient>()
      apiServiceProvider.issuesApi(YOUTRACK_TEST_URI, "123").shouldBeInstanceOf<IssuesApi>()
    }
  }
})
