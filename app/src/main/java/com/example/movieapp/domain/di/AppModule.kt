import com.example.movieapp.data.network.MovieApiService
import com.example.movieapp.data.network.repoImpl.MovieRepositoryImpl
import com.example.movieapp.data.usecase.GetMovieListUseCase
import com.example.movieapp.domain.repository.IMovieRepository
import com.example.movieapp.domain.util.Constants
import com.example.movieapp.presentation.movie_list_screen.MovieListViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @get:Provides
    @Singleton
    val api   : MovieApiService by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(): IMovieRepository {
        return MovieRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideGetMovieListUseCase(repository: MovieRepositoryImpl): GetMovieListUseCase {
        return GetMovieListUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideMovieListViewModel(): MovieListViewModel {
        return MovieListViewModel()
    }
}
