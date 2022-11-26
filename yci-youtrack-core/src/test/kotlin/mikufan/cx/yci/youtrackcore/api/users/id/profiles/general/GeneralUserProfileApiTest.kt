package mikufan.cx.yci.youtrackcore.api.users.id.profiles.general

import io.kotest.common.ExperimentalKotest
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import mikufan.cx.yci.youtrackcore.model.BaseYouTrackApiRequest
import mikufan.cx.yci.youtrackcore.util.ENABLE_BY_TOKEN
import mikufan.cx.yci.youtrackcore.util.YOUTRACK_TEST_BEARER_TOKEN
import mikufan.cx.yci.youtrackcore.util.YOUTRACK_TEST_URI
import org.springframework.boot.test.context.SpringBootTest
import java.time.ZoneId

@OptIn(ExperimentalKotest::class)
@SpringBootTest
class GeneralUserProfileApiTest(
  private val generalUserProfileApi: GeneralUserProfileApi,
) : ShouldSpec({
  context("for me").config(enabledOrReasonIf = ENABLE_BY_TOKEN) {
    should("get zone id") {
      val zoneId = generalUserProfileApi.getZoneIdOfUser(
        youTrackApiRequest = BaseYouTrackApiRequest(
          YOUTRACK_TEST_URI,
          YOUTRACK_TEST_BEARER_TOKEN
        )
      )
      zoneId shouldBe ZoneId.of("America/Toronto")
    }
  }
})