<?php

namespace app\controllers;

use app\models\Kunden;
use app\models\KundenSearch;
use yii\web\Controller;
use yii\web\NotFoundHttpException;
use yii\filters\VerbFilter;
use yii\filters\AccessControl;

/**
 * KundenController implements the CRUD actions for Kunden model.
 */
class KundenController extends Controller
{
    /**
     * @inheritDoc
     */
    public function behaviors()
    {
        return array_merge(
            parent::behaviors(),
            [
                'access' => [
                    'class' => AccessControl::class,
                    'rules' => [
                        [
                            'allow' => true,
                            'roles' => ['@'],
                            'matchCallback' => function ($rule, $action) {
                                return \Yii::$app->user->identity->role === 'admin';
                            }
                        ],
                    ],
                ],
                'verbs' => [
                    'class' => VerbFilter::className(),
                    'actions' => [
                        'delete' => ['POST'],
                    ],
                ],
            ]
        );
    }

    /**
     * Lists all Kunden models.
     *
     * @return string
     */
    public function actionIndex()
    {
        $searchModel = new KundenSearch();
        $dataProvider = $searchModel->search($this->request->queryParams);

        return $this->render('index', [
            'searchModel' => $searchModel,
            'dataProvider' => $dataProvider,
        ]);
    }

    /**
     * Displays a single Kunden model.
     * @param int $KundenID Kunden ID
     * @return string
     * @throws NotFoundHttpException if the model cannot be found
     */
    public function actionView($KundenID)
    {
        return $this->render('view', [
            'model' => $this->findModel($KundenID),
        ]);
    }

    /**
     * Creates a new Kunden model.
     * If creation is successful, the browser will be redirected to the 'view' page.
     * @return string|\yii\web\Response
     */
    public function actionCreate()
    {
        $model = new Kunden();

        if ($this->request->isPost) {
            if ($model->load($this->request->post()) && $model->save()) {
                return $this->redirect(['view', 'KundenID' => $model->KundenID]);
            }
        } else {
            $model->loadDefaultValues();
        }

        return $this->render('create', [
            'model' => $model,
        ]);
    }

    /**
     * Updates an existing Kunden model.
     * If update is successful, the browser will be redirected to the 'view' page.
     * @param int $KundenID Kunden ID
     * @return string|\yii\web\Response
     * @throws NotFoundHttpException if the model cannot be found
     */
    public function actionUpdate($KundenID)
    {
        $model = $this->findModel($KundenID);

        if ($this->request->isPost && $model->load($this->request->post()) && $model->save()) {
            return $this->redirect(['view', 'KundenID' => $model->KundenID]);
        }

        return $this->render('update', [
            'model' => $model,
        ]);
    }

    /**
     * Deletes an existing Kunden model.
     * If deletion is successful, the browser will be redirected to the 'index' page.
     * @param int $KundenID Kunden ID
     * @return \yii\web\Response
     * @throws NotFoundHttpException if the model cannot be found
     */
    public function actionDelete($KundenID)
    {
        $this->findModel($KundenID)->delete();

        return $this->redirect(['index']);
    }

    /**
     * Finds the Kunden model based on its primary key value.
     * If the model is not found, a 404 HTTP exception will be thrown.
     * @param int $KundenID Kunden ID
     * @return Kunden the loaded model
     * @throws NotFoundHttpException if the model cannot be found
     */
    protected function findModel($KundenID)
    {
        if (($model = Kunden::findOne(['KundenID' => $KundenID])) !== null) {
            return $model;
        }

        throw new NotFoundHttpException(Yii::t('app', 'The requested page does not exist.'));
    }
}
